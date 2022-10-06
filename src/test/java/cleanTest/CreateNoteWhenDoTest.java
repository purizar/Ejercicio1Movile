package cleanTest;

import activity.whenDo.CreateNoteForm;
import activity.whenDo.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.Date;

public class CreateNoteWhenDoTest {
    MainScreen mainScreen = new MainScreen();
    CreateNoteForm createNoteForm = new CreateNoteForm();

    @Test
    public void verifyCreateNewNote(){
        String title="Cato";
        String note="esta es una nota";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTxtBox.setText(title);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(title),
                "ERROR, the note was not created");

    }

    @AfterEach
    public void closeApp(){
        Session.getInstance().closeApp();
    }



}
