import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class ChessTowerMovement extends JFrame {
        private JButton[][] boardButtons;
        private int[][] boardState;

        public ChessTowerMovement() {
            setTitle("Torre en Ajedrez");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            initializeBoard();
            resetBoardState();

            setVisible(true);
        }

        private void initializeBoard() {
            JPanel boardPanel = new JPanel(new GridLayout(8, 8));
            boardButtons = new JButton[8][8];

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(50, 50));
                    button.setOpaque(true);
                    button.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                    button.addActionListener(new ButtonClickListener(i, j));
                    boardPanel.add(button);
                    boardButtons[i][j] = button;
                }
            }

            add(boardPanel, BorderLayout.CENTER);
        }

        private void resetBoardState() {
            boardState = new int[8][8];
            // Coloca la torre en la posición inicial (fila 0, columna 0)
            boardState[0][0] = 1; // Supongamos que el valor 1 representa la torre
            updateBoard();
        }

        private void updateBoard() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (boardState[i][j] == 1) {
                        boardButtons[i][j].setText("T");
                    } else {
                        boardButtons[i][j].setText("");
                    }
                }
            }
        }

        private class ButtonClickListener implements ActionListener {
            private int row, col;

            public ButtonClickListener(int row, int col) {
                this.row = row;
                this.col = col;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // Realiza el movimiento de la torre si la casilla está ocupada por la torre
                if (boardState[row][col] == 1) {
                    // Reinicia el tablero antes de hacer un nuevo movimiento
                    resetBoardState();
                    // Simplemente imprime los movimientos válidos (en este caso, los movimientos de la torre)
                    System.out.println("Movimientos válidos para la torre en la posición [" + row + "," + col + "]");
                    for (int i = 0; i < 8; i++) {
                        if (i != row) {
                            System.out.println("[" + i + "," + col + "]");
                        }
                        if (i != col) {
                            System.out.println("[" + row + "," + i + "]");
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(ChessTowerMovement::new);
        }
    }


