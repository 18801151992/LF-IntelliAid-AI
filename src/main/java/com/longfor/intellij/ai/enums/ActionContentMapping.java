package com.longfor.intellij.ai.enums;


public enum ActionContentMapping {
    EXPLAIN_CODE("Explain this Code", "请解释这段代码的功能和它执行的步骤"),
    COMMENT_GENERATOR("Generate Comment", "给定以下代码，生成摘要注释和最终代码"),
    ANALYZE_CODE("Performance Check", "给定以下代码，列出代码中的性能问题，以及修复后的代码"),
    SECURITY_AUDIT("Security Check", "给定以下代码，列出代码中的安全问题，以及修复后的代码"),
    STYLE_INSPECTION("Style Check", "给定以下代码，列出代码中的代码风格问题，以及修正的代码"),
    CODE_CLEANER("Clean Code", "给定以下代码，让我的代码变得整洁,只需要输出整洁后的代码，不要输出多余的文字"),
    UNIT_TEST_CREATOR("Generate Unit Test", "给定以下代码，使用最好的单元测试框架，针对每个函数的单元测试代码，包括正向和负向测试用例。测试用例旨在确保代码的正确功能，包括测试输入和输出、边界情况、特殊情况和异常情况。");

    private final String actionText;
    private final String content;

    ActionContentMapping(String actionText, String content) {
        this.actionText = actionText;
        this.content = content;
    }

    public static String getContentByActionText(String actionText) {
        for (ActionContentMapping mapping : values()) {
            if (mapping.actionText.equals(actionText)) {
                return mapping.content;
            }
        }
        return null; // or throw an exception if actionText is not valid
    }

    // Getters and other methods if needed
}
