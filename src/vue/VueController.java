package vue;

import entities.Vol;
import service.VolService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VueController implements Initializable {

    @FXML private TextField txtNumeroVol;
    @FXML private TextField txtDestination;
    @FXML private TextField txtCompagnie;
    @FXML private ComboBox<String> cmbTypeVol;
    @FXML private TextField txtPlaces;
    @FXML private CheckBox chkStatut;
    @FXML private TextField txtRecherche;
    @FXML private TableView<Vol> tableVols;
    @FXML private TableColumn<Vol, Integer> colId;
    @FXML private TableColumn<Vol, String> colNumero;
    @FXML private TableColumn<Vol, String> colDestination;
    @FXML private TableColumn<Vol, String> colCompagnie;
    @FXML private TableColumn<Vol, String> colType;
    @FXML private TableColumn<Vol, Integer> colPlaces;
    @FXML private TableColumn<Vol, Boolean> colStatut;

    private VolService service = new VolService();
    private ObservableList<Vol> listeVols = FXCollections.observableArrayList();
    private Vol volSelectionne = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numeroVol"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colCompagnie.setCellValueFactory(new PropertyValueFactory<>("compagnie"));
        colType.setCellValueFactory(new PropertyValueFactory<>("typeVol"));
        colPlaces.setCellValueFactory(new PropertyValueFactory<>("placesDisponibles"));
        colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));

        cmbTypeVol.setItems(FXCollections.observableArrayList(
            "International", "National", "Charter"
        ));

        tableVols.setOnMouseClicked(e -> {
            volSelectionne = tableVols.getSelectionModel().getSelectedItem();
            if (volSelectionne != null) {
                txtNumeroVol.setText(volSelectionne.getNumeroVol());
                txtDestination.setText(volSelectionne.getDestination());
                txtCompagnie.setText(volSelectionne.getCompagnie());
                cmbTypeVol.setValue(volSelectionne.getTypeVol());
                txtPlaces.setText(String.valueOf(volSelectionne.getPlacesDisponibles()));
                chkStatut.setSelected(volSelectionne.isStatut());
            }
        });

        actualiser();
    }

    @FXML
    private void ajouter() {
        Vol vol = new Vol(
            txtNumeroVol.getText(),
            txtDestination.getText(),
            txtCompagnie.getText(),
            cmbTypeVol.getValue(),
            Integer.parseInt(txtPlaces.getText()),
            chkStatut.isSelected()
        );
        service.ajouter(vol);
        actualiser();
        viderFormulaire();
    }

    @FXML
    private void modifier() {
        if (volSelectionne != null) {
            volSelectionne.setNumeroVol(txtNumeroVol.getText());
            volSelectionne.setDestination(txtDestination.getText());
            volSelectionne.setCompagnie(txtCompagnie.getText());
            volSelectionne.setTypeVol(cmbTypeVol.getValue());
            volSelectionne.setPlacesDisponibles(Integer.parseInt(txtPlaces.getText()));
            volSelectionne.setStatut(chkStatut.isSelected());
            service.modifier(volSelectionne);
            actualiser();
            viderFormulaire();
        }
    }

    @FXML
    private void supprimer() {
        if (volSelectionne != null) {
            service.supprimer(volSelectionne);
            actualiser();
            viderFormulaire();
        }
    }

    @FXML
    public void actualiser() {
        listeVols.clear();
        listeVols.addAll(service.listerTous());
        tableVols.setItems(listeVols);
    }

    @FXML
    private void rechercher() {
        String motCle = txtRecherche.getText();
        if (motCle.isEmpty()) {
            actualiser();
        } else {
            listeVols.clear();
            listeVols.addAll(service.rechercher(motCle));
            tableVols.setItems(listeVols);
        }
    }

    private void viderFormulaire() {
        txtNumeroVol.clear();
        txtDestination.clear();
        txtCompagnie.clear();
        cmbTypeVol.setValue(null);
        txtPlaces.clear();
        chkStatut.setSelected(false);
        volSelectionne = null;
    }
}