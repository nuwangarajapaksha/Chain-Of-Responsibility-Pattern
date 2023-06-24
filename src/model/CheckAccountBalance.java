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
public class CheckAccountBalance implements Chain {

    private Chain nextInChain;

    @Override
    public void nextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public String validate(CardDetails request) {
        if (request.getValidation().equals("accountBalance")) {

            double value = Double.parseDouble(request.getDetail());
            if (value <= 35000.0) {
                return "true";
            }
        } else {
            this.nextInChain.validate(request);
        }

        return "false";
    }

}
