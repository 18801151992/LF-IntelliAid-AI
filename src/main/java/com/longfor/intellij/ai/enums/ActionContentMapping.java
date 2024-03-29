package com.longfor.intellij.ai.enums;


public enum ActionContentMapping {
    EXPLAIN_CODE("Explain this Code", "提供一段编程代码，并详细解释其功能与执行流程。包括对每个关键函数、循环、条件判断和重要变量的作用的解释。说明代码如何协同工作以实现其既定目的，以及在运行时可能遇到的任何重要考虑因素。假设读者对所用编程语言有基础了解，但需要对这段特定代码的工作原理和逻辑结构有更深入的理解。"),
    COMMENT_GENERATOR("Generate Comment", "首先，提供一段完整的编程代码。这段代码应该执行一个具体的任务，比如数据处理、用户输入处理、或与外部API的交互。接着，创建一个简洁但全面的摘要注释，概述代码的主要功能和目的。在摘要注释中，包含关键的算法步骤、主要函数和方法的用途，以及代码如何实现其功能。最后，呈现完整的代码，确保代码清晰、结构良好，并且包含必要的行内注释，以帮助理解代码的每个部分。假设目标读者是具有一定编程背景的人员，但不一定熟悉这段特定代码的细节。"),
    ANALYZE_CODE("Performance Check", "展示一段具有性能问题的编程代码。这段代码可能包含低效的算法、不必要的资源消耗、过度的内存使用或其他性能瓶颈。首先，简要分析并指出代码中的具体性能问题，解释为什么这些做法会影响代码的效率和性能。然后，提供修复后的代码版本，展示如何通过优化算法、减少资源消耗、提高内存效率或其他方法来解决这些性能问题。确保在修复版本中详细注释修改的部分，说明每项改动如何提高代码的性能。最后，比较修复前后的代码，总结优化带来的性能提升和潜在影响。目标读者为具有一定编程背景的人员，他们对代码优化和性能改进感兴趣。"),
    SECURITY_AUDIT("Security Check", "展示一段存在安全漏洞的编程代码。这段代码可能包含诸如SQL注入、未经处理的用户输入、不安全的数据存储或其他安全弱点。首先，对代码中的安全漏洞进行详细分析，指出具体的安全隐患及其可能导致的风险。随后，提供一个修复后的代码版本，展示如何通过合理的安全措施、数据验证、加密技术或其他方法来解决这些安全问题。确保在修复版本中详细注释对代码所做的修改，解释每项改动如何增强代码的安全性。最后，对比修复前后的代码，总结安全性提升的重要性和对整体应用程序的影响。此提示词面向有一定编程背景的人员，特别是对提高代码安全性感兴趣的开发者。"),
    STYLE_INSPECTION("Style Check", "呈现一段编程代码，并指出其中的代码风格问题。这些问题可能包括不一致的命名约定、缺乏适当的缩进和格式化、过度复杂的函数或方法、缺乏注释等。首先，详细识别并解释代码中存在的风格问题以及它们为何不符合标准的编程实践或特定语言的最佳实践。接着，提供一个修正后的代码版本，展示如何通过重构代码、改善命名、添加必要的注释、以及应用一致的格式化标准来解决这些风格问题。确保在修正版本中详细注释所做的更改，解释每项改动如何提高代码的可读性和可维护性。最后，对比修正前后的代码，总结代码风格改进的重要性以及它对代码质量的长期影响。此提示词适用于教育、代码审查或提升编程实践的场景，面向有一定编程背景但希望提高代码质量的开发者。"),
    CODE_CLEANER("Clean Code", "提供一段需要重构以提高其整洁度的编程代码。这段代码可能存在各种问题，如复杂的逻辑、冗余的代码、不一致的命名规则、缺乏适当的格式化和缩进、或者缺少必要的注释。重点是通过重构来提高代码的清晰度、可读性和可维护性。在重构过程中，应用如下改进：简化复杂的表达式，删除重复的代码段，统一命名约定，应用一致且清晰的格式化和缩进规则，并在关键部分添加简洁明了的注释。最终，展示重构后的代码，确保它不仅更加整洁，而且更易于理解和维护。此提示词适用于代码优化和重构的场景，面向希望提高代码整洁度和质量的开发者。"),
    UNIT_TEST_CREATOR("Generate Unit Test", "提供一段特定的编程代码，它执行一个明确的功能，例如一个函数或一个类的方法。这段代码可以是进行数学计算、处理字符串、操作数据结构或与外部系统交互的代码。接着，创建一个单元测试类来对这段代码进行全面测试。单元测试应该包括对各种输入（包括边界情况和异常输入）的测试案例，验证代码是否正确地执行其预期功能。在测试类中，为每个测试案例编写清晰的断言语句，以确保代码在不同情况下的表现符合预期。同时，确保测试涵盖所有关键的代码路径和潜在的边界条件。最后，展示完整的单元测试类，包括所有测试方法和必要的设置/拆卸逻辑。此提示词适用于软件开发和质量保证的场景，面向希望确保其代码健壮性和可靠性的开发者。"),
    IMPROVE_READABILITY("Improve Readability", "提供一段具有一定复杂度的编程代码，这段代码可能因为复杂的逻辑、缺乏适当的组织结构、不一致的命名规则、或缺少注释而难以理解。目标是通过各种重构技术来改善代码的可读性。首先，分析代码中存在的可读性问题，如混乱的结构、难以理解的变量名、缺乏注释等。然后，针对这些问题，进行适当的重构，包括但不限于重新组织代码结构、简化复杂逻辑、统一和明确命名约定、添加或优化注释。重构的重点是使代码更加清晰、直观和易于理解，而不是改变其功能。最终，展示重构后的代码，并解释所做的每项改动如何有助于提高代码的整体可读性。此提示词适用于软件开发、代码审查、编程教育的场景，面向那些希望提高代码质量和可维护性的开发者。");

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
