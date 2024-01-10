package com.longfor.intellij.ai.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.jcef.JBCefApp;
import com.intellij.ui.jcef.JBCefBrowser;
import com.intellij.ui.jcef.JBCefClient;
import org.jetbrains.annotations.NotNull;

/**
 * @Author deven
 * @Date 2023-12-28 14:25
 */
public class LFWindow implements ToolWindowFactory {


//    private JBCefBrowser browser;
//
//    public LFWindow() {
//        this.browser = new JBCefBrowser("http://10.237.0.205:8000/plugins/code_review_idea/frontend/bito.html");
//    }

    public static final Key<LFWindow> MY_TOOL_WINDOW_KEY = Key.create("LFWindow");

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        project.putUserData(MY_TOOL_WINDOW_KEY, this);
        JBCefBrowser browser = new JBCefBrowser("https://www.google.com");

        // 创建内容并添加到工具窗口
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(browser.getComponent(), "", false);
        toolWindow.getContentManager().addContent(content);

        // 设置工具窗口的标题为空，以便只显示图标
        toolWindow.setStripeTitle("");
        toolWindow.setTitle("LF");

    }
}
