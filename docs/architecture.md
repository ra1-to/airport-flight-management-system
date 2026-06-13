# Architecture

The application follows an MVC-oriented structure:

| Layer | Package | Responsibility |
|---|---|---|
| Model | `entities` | JPA entity representing a flight |
| Persistence | `util` | Hibernate `SessionFactory` configuration |
| Service | `service` | CRUD operations and search logic |
| View / Controller | `vue` | JavaFX FXML interface and controller logic |
| Entry point | `main` | JavaFX application launcher |

## Main Classes

- `Vol`: JPA entity mapped to the `vol` table.
- `HibernateUtil`: initializes and exposes a singleton `SessionFactory`.
- `VolService`: implements create, update, delete, list, and search operations.
- `VueController`: connects the JavaFX interface to the service layer.
- `VueFX` / `Main`: launch the JavaFX desktop application.
