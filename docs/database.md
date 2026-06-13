# Database

The application uses a MySQL database named `gestion_aeropuertos` and one main table named `vol`.

## Table: `vol`

| Column | Type | Description |
|---|---|---|
| `id` | INT, PK, AUTO_INCREMENT | Unique flight identifier |
| `numero_vol` | VARCHAR(20) | Flight number |
| `destination` | VARCHAR(100) | Flight destination |
| `compagnie` | VARCHAR(100) | Airline company |
| `type_vol` | VARCHAR(50) | Flight type: International, National, or Charter |
| `places_disponibles` | INT | Available seats |
| `statut` | BOOLEAN | Availability status |

Use `database/schema.sql` to create the database structure and `database/sample_data.sql` for optional test data.
