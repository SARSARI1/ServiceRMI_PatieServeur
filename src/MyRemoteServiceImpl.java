import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    ArrayList<Livre> listeLivres = new ArrayList<Livre>();
    protected MyRemoteServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public boolean ajouterLivre(Livre livre) throws RemoteException {
        int taille=listeLivres.size();
        listeLivres.add(livre);
        if(listeLivres.size()>taille){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Livre RechercheLivre(String nom) throws RemoteException {
        for(Livre livre : listeLivres){
            if(livre.getName().equals(nom)){
                return livre;
            }
        }
        return null;
    }

    @Override
    public List<Livre> ListerLivres() throws RemoteException {
        return listeLivres;
    }
}
