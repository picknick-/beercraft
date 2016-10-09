package eu.mszulc.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.mszulc.controller.GreetMe;
import eu.mszulc.view.util.NotificationWindow;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = GreetView.VIEW_NAME)
public class GreetView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "ui";

    @Autowired
    private GreetMe greeter;

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a UI scoped view. Greeter says: " + greeter.sayHello()));
        Button button = new Button("Hey jude");
        addComponent(button);
        button.addStyleName(ValoTheme.BUTTON_DANGER);
        button.addClickListener(event -> getUI().addWindow(new NotificationWindow("Don't paint it black","Sunshine")));
        addComponent(new Button("Hey jude"));
        addComponent(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
