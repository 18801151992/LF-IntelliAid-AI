package com.longfor.intellij.ai.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeDetail {

    private String content;
    private String actionText;
    private String selectionText;
    private String selectedText;
    private String fileName;

}
