package cleanTest;

import activity.whenDo.EditNoteForm;
import activity.whenDo.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class CrudNoteWhenDoTest {
    MainScreen mainScreen = new MainScreen();
    EditNoteForm editNoteForm = new EditNoteForm();

    @Test
    public void verifyCrudNote(){
        String title="Nota 1";
        String note="Esta es la nota 1";

        String newTitle="Nota 2";
        String newNote="Esta es la Nota 2";

        mainScreen.addNoteButton.click();
        editNoteForm.titleTxtBox.setText(title);
        editNoteForm.noteTxtBox.setText(note);
        editNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(title),
                "ERROR, the note was not created");
        mainScreen.selectNote(title);
        editNoteForm.titleTxtBox.setText(newTitle);
        editNoteForm.noteTxtBox.setText(newNote);
        editNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(newTitle),
                "ERROR, the note was not updated");

        mainScreen.selectNote(newTitle);
        editNoteForm.deleteButton.click();
        editNoteForm.deleteConfirmButton.click();
        Assertions.assertFalse(mainScreen.isNoteDisplayed(newTitle),
                "ERROR, the note was not deleted");
    }

    @AfterEach
    public void closeApp(){
        Session.getInstance().closeApp();
    }


}
