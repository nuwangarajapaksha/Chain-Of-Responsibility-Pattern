/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NUWAA
 */
public class CardDetails {
    private String detail;
    private String validation;

    public CardDetails(String detail, String validation) {
        this.detail = detail;
        this.validation = validation;
    }

    public String getDetail() {
        return detail;
    }

    public String getValidation() {
        return validation;
    }
    
}
