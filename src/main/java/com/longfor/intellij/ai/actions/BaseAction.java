package com.longfor.intellij.ai.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.longfor.intellij.ai.entity.CodeDetail;
import com.longfor.intellij.ai.enums.ActionContentMapping;
import com.longfor.intellij.ai.toolWindow.LFWindow;
import com.longfor.intellij.ai.utils.JsonUtil;
import lombok.val;
import org.jetbrains.annotations.NotNull;

/**
 * @Author deven
 * @Date 2024-01-11 16:10
 */
public abstract class BaseAction extends AnAction {


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // 获取选中的代码
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        if (editor == null) {
            return;
        }
        String actionText = e.getPresentation().getText();
        String selectedText = editor.getSelectionModel().getSelectedText();
        Document document = editor.getDocument();
        int startLine = document.getLineNumber(editor.getSelectionModel().getSelectionStart()) + 1;
        int endLine = document.getLineNumber(editor.getSelectionModel().getSelectionEnd()) + 1;
        VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
        String name = null;
        if (virtualFile != null) {
            name = virtualFile.getName();
        }
        CodeDetail build = new CodeDetail();
        build.setActionText(actionText);
        build.setSelectedText(selectedText);
        build.setSelectionText("#" + startLine + "-" + endLine);
        build.setContent(ActionContentMapping.getContentByActionText(actionText));
        build.setFileName(name);
        Project project = e.getProject();
        if (project == null) return;
        LFWindow lfWindow = project.getUserData(LFWindow.MY_TOOL_WINDOW_KEY);
        if (lfWindow != null) {
            val json = JsonUtil.toJson(build);
            lfWindow.sendDataToBrowser(json);
        }
        // 调用抽象方法执行特定逻辑
        executeCustomLogic(e, editor);
    }

    // 抽象方法，子类需要实现这个方法来执行特定逻辑
    protected abstract void executeCustomLogic(@NotNull AnActionEvent e, Editor editor);
}
