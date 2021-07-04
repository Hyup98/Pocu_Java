package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.Unit;

import java.util.ArrayList;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class SimulationVisualizer {
    private static final int NUM_COLUMNS = 16;
    private static final int NUM_ROWS = 8;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Boolean> aliveStatus = new ArrayList<>();

    public SimulationVisualizer(ArrayList<Unit> units) {
        for (Unit unit : units) {
            this.units.add(unit);
            this.aliveStatus.add(true);
        }
    }

    public void visualize(int frameNumber, ArrayList<Unit> units) {
        markDeadUnits(units);

        ArrayList<ArrayList<ArrayList<Unit>>> unitPositions = new ArrayList<>();

        for (int i = 0; i < NUM_ROWS; ++i) {
            unitPositions.add(new ArrayList<>());

            for (int j = 0; j < NUM_COLUMNS; ++j) {
                unitPositions.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < this.units.size(); ++i) {
            if (this.aliveStatus.get(i)) {
                Unit unit = this.units.get(i);

                int x = unit.getPosition().getX();
                int y = unit.getPosition().getY();

                unitPositions.get(y).get(x).add(unit);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Frame: %d", frameNumber));

        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        for (int i = 0; i < this.units.size(); ++i) {
            sb.append(String.format("%s(%c)", Integer.toHexString(i).toUpperCase(), this.units.get(i).getSymbol()));

            if (this.aliveStatus.get(i)) {
                sb.append(String.format("%02d", this.units.get(i).getHp()));
            } else {
                sb.append("XX");
            }

            sb.append(' ');

            if ((i + 1) % 4 == 0) {
                sb.append(System.lineSeparator());
            }
        }

        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        sb.append("  ");
        for (int i = 0; i < NUM_COLUMNS; ++i) {
            sb.append(Integer.toHexString(i).toUpperCase());
        }

        sb.append(System.lineSeparator());

        addHorizontalBorder(sb);

        ArrayList<ArrayList<Unit>> overlappedTiles = new ArrayList<>();

        for (int i = 0; i < NUM_ROWS; ++i) {
            sb.append(Integer.toHexString(i).toUpperCase());
            sb.append('|');

            for (int j = 0; j < NUM_COLUMNS; ++j) {
                ArrayList<Unit> uList = unitPositions.get(i).get(j);

                if (uList.isEmpty()) {
                    sb.append(' ');
                } else {
                    sb.append(Integer.toHexString(getUnitId(uList.get(0))).toUpperCase());

                    if (uList.size() > 1) {
                        overlappedTiles.add(uList);
                    }
                }
            }

            sb.append('|');
            sb.append(System.lineSeparator());
        }

        addHorizontalBorder(sb);

        sb.append(System.lineSeparator());

        for (int i = 0; i < overlappedTiles.size(); ++i) {
            ArrayList<String> ids = new ArrayList<>();

            for (Unit unit : overlappedTiles.get(i)) {
                ids.add(Integer.toHexString(getUnitId(unit)).toUpperCase());
            }

            sb.append(String.join("-", ids));
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }

    private void addHorizontalBorder(StringBuilder sb) {
        sb.append(' ');
        sb.append('+');
        for (int i = 0; i < NUM_COLUMNS; ++i) {
            sb.append('-');
        }
        sb.append('+');
        sb.append(System.lineSeparator());
    }

    private int getUnitId(Unit unit) {
        for (int i = 0; i < this.units.size(); ++i) {
            if (this.units.get(i) == unit) {
                return i;
            }
        }

        return -1;
    }

    private void markDeadUnits(ArrayList<Unit> units) {
        assert (this.units.size() >= units.size());

        for (int i = 0; i < this.units.size(); ++i) {
            if (!units.contains(this.units.get(i))) {
                this.aliveStatus.set(i, false);
            }
        }
    }
}