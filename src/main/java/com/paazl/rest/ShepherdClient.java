package com.paazl.rest;

import com.paazl.exception.ConnectionRefusedException;
import com.paazl.gui.GuiInterface;
import com.paazl.gui.MainPanel;
import com.paazl.gui.OrderRequestListener;
import com.paazl.utils.StatusUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShepherdClient {

    /*
        Use a Rest client to obtain the server status, so this client can be used to obtain that status.
     */

    private final Logger log = LoggerFactory.getLogger(getClass());

    private GuiInterface guiInterface;

    private final static MainPanel mainPanel = new MainPanel();

    @Autowired
    private ResponseHandler responseHandler;

    @Autowired
    public ShepherdClient(GuiInterface guiInterface) {
        this.guiInterface = guiInterface;

        guiInterface.addOrderRequestListener(new OrderRequestListener() {
            @Override
            public void orderRequest(int i) {

                guiInterface.addServerFeedback("Number of sheep to order: " + i);
                try {
                    guiInterface.addServerFeedback(responseHandler.responseForBuyingSheepRequest(i));
                } catch (ConnectionRefusedException e) {
                    guiInterface.addServerFeedback(e.getMessage());
                }
            }
        });
    }

    public String getServerStatus() {
        try {
            return StatusUtils.succeedServerAnswer(responseHandler.responseForBalanceRequest(),
                    responseHandler.responseForSheepConditionsRequest());
        } catch (ConnectionRefusedException e) {
            return e.getMessage();
        }
    }
}
