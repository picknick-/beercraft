package eu.mszulc.view.util;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class NotificationWindow extends Window {
    public NotificationWindow(String title,String body) {
        super(title);
        center();
        // Some basic content for the window
        VerticalLayout content = new VerticalLayout();
        content.addComponent(new Label(body));
        content.setMargin(true);
        setContent(content);
        //Disable size change
        setResizable(false);
        //Set only window as active.
        setModal(true);
        // Disable the close button
        setClosable(false);
        // Trivial logic for closing the sub-window
        Button ok = new Button("OK");
        ok.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                close(); // Close the sub-window
            }
        });
        content.addComponent(ok);
    }
}
