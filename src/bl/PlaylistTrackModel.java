/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javax.swing.AbstractListModel;

/**
 *
 * @author Steffie
 */
public class PlaylistTrackModel extends AbstractListModel
{

    private ObservableList<File> list = FXCollections.observableArrayList();
    private ListView view;

    public PlaylistTrackModel(ListView view)
    {
        this.view = view;
        view.setItems(list);
    }

    public void addTrack(File t)
    {
    //    String newName = t.getAbsolutePath().substring(t.getAbsolutePath().lastIndexOf("\\"), t.getAbsolutePath().length());
    //    t.renameTo();
        list.add(t);
        view.setItems(list);
    }

    public void removeTrackByObject(File t)
    {
        list.remove(t);
        view.setItems(list);
    }

    public void removeTrackByIndex(int index)
    {
        list.remove(index);
        view.setItems(list);
    }

    @Override
    public int getSize()
    {
        return list.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return list.get(index);
    }

}
