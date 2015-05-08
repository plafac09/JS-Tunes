/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;
import java.util.Collection;
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

    private ObservableList<Track> list = FXCollections.observableArrayList();
    private ListView view;

    public PlaylistTrackModel(ListView view)
    {
        this.view = view;
    }

    
    public void addTrack(Track t)
    {   
        list.add(t);
        view.setItems(list);
    }

    public void removeTrackByObject(Track t)
    {
        list.remove(t);
    }

    public void removeTrackByIndex(int index)
    {
        list.remove(index);
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
