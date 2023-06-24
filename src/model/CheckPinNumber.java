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
public class CheckPinNumber implements Chain {

    private Chain nextInChain;

    @Override
    public void nextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public String validate(CardDetails request) {
        String value = "";
        if (request.getValidation().equals("pinNumber")) {
            if (request.getDetail().equals("9317")) {
                value = "true";
            }
        } else {
            value = this.nextInChain.validate(request);
        }

        return value;
    }

}
