package com.longfor.intellij.ai.toolWindow;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.jcef.JBCefApp;
import com.intellij.ui.jcef.JBCefBrowser;
import com.intellij.ui.jcef.JBCefClient;
import com.jetbrains.cef.JCefAppConfig;
import org.apache.commons.text.StringEscapeUtils;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefRendering;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

/**
 * @author deven
 * 2023-12-28 14:25
 */
public class LFWindow implements ToolWindowFactory, DumbAware {



    private JBCefBrowser browser;

    public static final Key<LFWindow> MY_TOOL_WINDOW_KEY = Key.create("LFWindow");

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        project.putUserData(MY_TOOL_WINDOW_KEY, this);

        //if (!JBCefApp.isSupported()) return;

        //this.browser = createBrowser();

        // 创建内容并添加到工具窗口
//        ContentFactory contentFactory = ContentFactory.getInstance();
//        Content content = contentFactory.createContent(new MyWebToolWindowContent().getContent(), "MyTab", false);
//        toolWindow.getContentManager().addContent(content);
//
//        // 设置工具窗口的标题为空，以便只显示图标
//        toolWindow.setStripeTitle("LF");
//        toolWindow.setTitle("");

        browser = createBrowser("http://10.231.135.177:8001/plugins/code_review_idea/frontend/bito.html");
        Content content = toolWindow.getContentManager().getFactory().createContent(browser.getComponent(), "", false);
        toolWindow.getContentManager().addContent(content);
    }

//    private JBCefBrowser createBrowser() {
//        // 创建浏览器实例，可以添加更多的配置和错误处理
//        return new JBCefBrowser("http://10.231.135.177:8001/plugins/code_review_idea/frontend/bito.html");
//    }

    private final String user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.56";

    private JBCefBrowser createBrowser(String url) {
        if (!JBCefApp.isSupported()) {
            return null;
        }

        JBCefClient client = getJbCefClient();
        CefBrowser cefBrowser = client.getCefClient().createBrowser(url, CefRendering.DEFAULT, false);
        JBCefBrowser jbCefBrowser = new JBCefBrowser(cefBrowser, client);
        return jbCefBrowser;
    }

    private JBCefClient getJbCefClient() {
        CefSettings cefSettings = JCefAppConfig.getInstance().getCefSettings();
        cefSettings.user_agent = user_agent;
        cefSettings.locale = Locale.getDefault().toLanguageTag();
        List<String> args = JCefAppConfig.getInstance().getAppArgsAsList();
        args.add("--no-sandbox");
        args.add("--disable-web-security");
        args.add("--touch-events");
        args.add("--disable-spell-checking");
        args.add("--disable-notifications");
        args.add("--disable-logging");
        args.add("--ignore-certificate-errors");
        return JBCefApp.getInstance().createClient();
    }


    public void sendDataToBrowser(String data) {
        if (this.browser != null) {
            String escapedCode = StringEscapeUtils.escapeJava(data);
            String script = String.format("generate(\"%s\");", escapedCode);
            this.browser.getCefBrowser().executeJavaScript(script, this.browser.getCefBrowser().getURL(), 0);
        }
    }
}
