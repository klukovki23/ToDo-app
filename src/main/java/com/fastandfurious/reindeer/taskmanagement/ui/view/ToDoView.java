package com.fastandfurious.reindeer.taskmanagement.ui.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;


@Route("")
public class ToDoView extends VerticalLayout{

    private ToDoRepo repo;
    
    public ToDoView(ToDoRepo repo) {
        this.repo = repo;
        var task = new TextField();
        var button = new Button( "Add");
        var todos = new VerticalLayout();
        
        todos.setPadding(false);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        button.addClickListener(click-> {
         var ToDo = repo.save(new ToDo(task.getValue()));
         todos.add(createCheckbox(ToDo));
         task.clear();
        });

        repo.findAll().forEach(ToDo -> todos.add(createCheckbox(ToDo)));

        add(

            new H1("ToDo"),
            new HorizontalLayout(task, button),
            todos
        );
    }
    private Component createCheckbox(ToDo todo) {
      return new Checkbox(todo.getTask(), todo.isDone(), e-> {
          ToDo toDo = new ToDo(null);
          toDo.setDone(e.getValue());
          repo.save(todo);
      });
    }

}