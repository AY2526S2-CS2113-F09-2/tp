package seedu.duke.commands;

import java.util.ArrayList;
import java.util.List;

import seedu.duke.RecordList;
import seedu.duke.Ui;
import seedu.duke.exceptions.ResumakeException;
import seedu.duke.recordtype.Record;

public class GenerateCommand extends Command {
    private final Ui ui;

    public GenerateCommand(){
        this.ui = new Ui();
    }

    @Override
    public void execute(RecordList list) throws ResumakeException {
        List<String> recordTypes = new ArrayList<>(List.of("Cca", "Experience", "Project"));

        for (String type : recordTypes){
            ui.showMessage(type);
            String charType = type.substring(0,1);
            Integer index = 1;
            for (Record record : list){
                if (type.equals("all") || record.getRecordType().equals(charType)) {
                    new ShowCommand(index).execute(list);
                }
                index++;
            }
            ui.showLine();
        }

    }
}
