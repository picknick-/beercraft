package eu.mszulc.controller;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.mszulc.view.AnotherViewInAWall;
import eu.mszulc.view.DefaultView;
import eu.mszulc.view.GreetView;
import eu.mszulc.view.ListView;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class SiteUI extends UI {
    // we can use either constructor autowiring or field autowiring
    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("Home", DefaultView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Another View in A wall", AnotherViewInAWall.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Greet View", GreetView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("List", ListView.VIEW_NAME));
        root.addComponent(navigationBar);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
}

