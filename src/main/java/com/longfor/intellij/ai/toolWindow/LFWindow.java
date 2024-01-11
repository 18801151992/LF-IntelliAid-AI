package com.longfor.intellij.ai.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.jcef.JBCefApp;
import com.intellij.ui.jcef.JBCefBrowser;
import org.apache.commons.lang.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;

/**
 * @author deven
 * 2023-12-28 14:25
 */
public class LFWindow implements ToolWindowFactory {


    private JBCefBrowser browser;

    public static final Key<LFWindow> MY_TOOL_WINDOW_KEY = Key.create("LFWindow");

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        project.putUserData(MY_TOOL_WINDOW_KEY, this);

        if (!JBCefApp.isSupported()) return;

        this.browser = createBrowser();

        // 创建内容并添加到工具窗口
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(browser.getComponent(), "", false);
        toolWindow.getContentManager().addContent(content);

        // 设置工具窗口的标题为空，以便只显示图标
        toolWindow.setStripeTitle("LF");
        toolWindow.setTitle("");

    }

    private JBCefBrowser createBrowser() {
        // 创建浏览器实例，可以添加更多的配置和错误处理
        return new JBCefBrowser("http://10.231.135.177:8001/plugins/code_review_idea/frontend/bito.html");
    }


    public void sendDataToBrowser(String data) {
        if (this.browser != null) {
            String escapedCode = StringEscapeUtils.escapeJava(data);
            String script = String.format("generate(\"%s\");", escapedCode);
            this.browser.getCefBrowser().executeJavaScript(script, this.browser.getCefBrowser().getURL(), 0);
        }
    }
}
