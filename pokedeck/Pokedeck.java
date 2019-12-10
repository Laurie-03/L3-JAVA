import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Pokedeck {
    /* ----- Initialization ----- */
    protected static Deck pokedeck = new Deck();
    protected static JFrame window = new JFrame("Pokedeck");
    protected static JButton addButton = new JButton("Add");
    protected static JButton updateButton = new JButton("Update");
    protected static JButton removeButton = new JButton("Remove");
    protected static JButton previousCardButton = new JButton("Previous Card");
    protected static JButton nextCardButton = new JButton("Next Card");
    protected static JLabel nameCardLabel;
    protected static JLabel lifePointsCardLabel;
    protected static JLabel typeCardLabel;
    protected static JLabel descriptionCardLabel;
    protected static int index;
    protected static JList<String> cardsList;
    protected static JScrollPane listScrollable;
    protected static ArrayList<String> listCard;

    public static void main(String[] args) {  
        pokedeck.addCard(new Card("Pikachu", "60", "Electrik", "Pichu's evolution"));
        pokedeck.addCard(new Card("Pichu", "20", "Electrik", "Pikachu's baby"));    
        /* ----- Swing Zoning ----- */
            window.setSize(500, 400);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /* --- Menu Panel --- */
            JPanel menuPanel = new JPanel(new FlowLayout());
            addButton.addActionListener(new AddCard());
            updateButton.addActionListener(new UpdateCard());
            removeButton.addActionListener(new RemoveCard());
            previousCardButton.addActionListener(new PreviousCard());
            nextCardButton.addActionListener(new NextCard());

            menuPanel.add(addButton);
            menuPanel.add(updateButton);
            menuPanel.add(removeButton);
            menuPanel.add(previousCardButton);
            menuPanel.add(nextCardButton);
            menuPanel.setPreferredSize(new Dimension(500, 50));

            /* --- Pokemon Card Panel --- */
            JPanel contentPanel = new JPanel(new GridLayout(1, 2, 2, 2));
            JPanel cardPanel = new JPanel(new CardLayout());
            cardPanel.setLayout(new BorderLayout());
            index = 0;
            nameCardLabel = new JLabel(pokedeck.getCard(index).getName());
            nameCardLabel.setPreferredSize(new Dimension(215, 25));
            nameCardLabel.setHorizontalAlignment(JLabel.CENTER);
            lifePointsCardLabel = new JLabel(pokedeck.getCard(index).getLifePoints());
            nameCardLabel.setPreferredSize(new Dimension(107, 25));
            typeCardLabel = new JLabel(pokedeck.getCard(index).getType());
            nameCardLabel.setPreferredSize(new Dimension(108, 25));
            descriptionCardLabel = new JLabel(pokedeck.getCard(index).getDescription());
            descriptionCardLabel.setPreferredSize(new Dimension(215, 200));
            descriptionCardLabel.setHorizontalAlignment(JLabel.CENTER);
            cardPanel.add(nameCardLabel, BorderLayout.NORTH);
            cardPanel.add(lifePointsCardLabel, BorderLayout.WEST);
            cardPanel.add(typeCardLabel, BorderLayout.EAST);
            cardPanel.add(descriptionCardLabel,BorderLayout.SOUTH);
            cardPanel.setPreferredSize(new Dimension(215, 250));
            cardPanel.setBackground(Color.BLUE);
            nameCardLabel.setForeground(Color.YELLOW);
            lifePointsCardLabel.setForeground(Color.YELLOW);
            typeCardLabel.setForeground(Color.YELLOW);
            descriptionCardLabel.setForeground(Color.YELLOW);

            /* --- List Cards Panel --- */
            JPanel listCardPanel = new JPanel();
            listCardPanel.setPreferredSize(new Dimension(215, 250));
            final ArrayList<String> listCard = new ArrayList<String>();
            for (int i = 0; i < pokedeck.deck.size(); i++) {
                Card selectCard = pokedeck.deck.get(i);
                listCard.add(selectCard.getName());
            }
            cardsList = new JList<>(listCard.toArray(new String[0]));
            listScrollable = new JScrollPane(cardsList);
            listScrollable.setPreferredSize(new Dimension(215, 250));
            listCardPanel.add(listScrollable);

            /* --- Window Panels --- */
            contentPanel.setLayout(new FlowLayout());
            contentPanel.add(cardPanel);
            contentPanel.add(listCardPanel);

            window.setLayout(new BorderLayout());        
            window.add(menuPanel, BorderLayout.NORTH);
            window.add(contentPanel, BorderLayout.CENTER);

            window.setVisible(true);
        /* ----- End Swing Zoning ----- */
    }

    public static class AddCard implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame windowNewCard = new JFrame("Add New Card");
            windowNewCard.setSize(500, 200);

            JPanel namePanel = new JPanel();
            JPanel lifePointsPanel = new JPanel();
            JPanel typePanel = new JPanel();
            JPanel descriptionPanel = new JPanel();
            JPanel addButtonPanel = new JPanel();

            JLabel nameLabel = new JLabel("Name :");
            JTextField nameTextField = new JTextField();
            nameTextField.setPreferredSize(new Dimension(100, 20));
            namePanel.add(nameLabel);
            namePanel.add(nameTextField);

            JLabel lifePointsLabel = new JLabel("Life Points :");
            JTextField lifePointsTextField = new JTextField();
            lifePointsTextField.setPreferredSize(new Dimension(100, 20));
            lifePointsPanel.add(lifePointsLabel);
            lifePointsPanel.add(lifePointsTextField);

            JLabel typeLabel = new JLabel("Type :");
            JTextField typeTextField = new JTextField();
            typeTextField.setPreferredSize(new Dimension(100, 20));
            typePanel.add(typeLabel);
            typePanel.add(typeTextField);

            JLabel descriptionLabel = new JLabel("Description :");
            JTextField descriptionTextField = new JTextField();
            descriptionTextField.setPreferredSize(new Dimension(100, 20));
            descriptionPanel.add(descriptionLabel);
            descriptionPanel.add(descriptionTextField);

            JButton addActionButton = new JButton("Add Card");
            addButtonPanel.add(addActionButton);

            windowNewCard.setLayout(new GridLayout(5, 1, 0, 0));
            windowNewCard.add(namePanel);
            windowNewCard.add(lifePointsPanel);
            windowNewCard.add(typePanel);
            windowNewCard.add(descriptionPanel);
            windowNewCard.add(addButtonPanel);

            windowNewCard.setVisible(true);

            addActionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String nameText = nameTextField.getText();
                    String lifePointsText = lifePointsTextField.getText();
                    String typeText = typeTextField.getText();
                    String descriptionText = descriptionTextField.getText();
                    pokedeck.addCard(new Card(nameText, lifePointsText, typeText, descriptionText));
                    
                    window.revalidate();
                    window.repaint();

                    windowNewCard.setVisible(false);
                }
            });
        }
    }

    public static class UpdateCard implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame windowUpdateCard = new JFrame("Update Card");
            windowUpdateCard.setSize(500, 200);

            JPanel namePanel = new JPanel();
            JPanel lifePointsPanel = new JPanel();
            JPanel typePanel = new JPanel();
            JPanel descriptionPanel = new JPanel();
            JPanel updateButtonPanel = new JPanel();

            JLabel nameLabel = new JLabel("Name :");
            JTextField nameTextField = new JTextField(pokedeck.getCard(index).getName());
            nameTextField.setPreferredSize(new Dimension(100, 20));
            namePanel.add(nameLabel);
            namePanel.add(nameTextField);

            JLabel lifePointsLabel = new JLabel("Life Points :");
            JTextField lifePointsTextField = new JTextField(pokedeck.getCard(index).getLifePoints());
            lifePointsTextField.setPreferredSize(new Dimension(100, 20));
            lifePointsPanel.add(lifePointsLabel);
            lifePointsPanel.add(lifePointsTextField);

            JLabel typeLabel = new JLabel("Type :");
            JTextField typeTextField = new JTextField(pokedeck.getCard(index).getType());
            typeTextField.setPreferredSize(new Dimension(100, 20));
            typePanel.add(typeLabel);
            typePanel.add(typeTextField);

            JLabel descriptionLabel = new JLabel("Description :");
            JTextField descriptionTextField = new JTextField(pokedeck.getCard(index).getDescription());
            descriptionTextField.setPreferredSize(new Dimension(100, 20));
            descriptionPanel.add(descriptionLabel);
            descriptionPanel.add(descriptionTextField);

            JButton updateActionButton = new JButton("Update Card");
            updateButtonPanel.add(updateActionButton);

            windowUpdateCard.setLayout(new GridLayout(5, 1, 0, 0));
            windowUpdateCard.add(namePanel);
            windowUpdateCard.add(lifePointsPanel);
            windowUpdateCard.add(typePanel);
            windowUpdateCard.add(descriptionPanel);
            windowUpdateCard.add(updateButtonPanel);

            updateActionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String nameText = nameTextField.getText();
                    String lifePointsText = lifePointsTextField.getText();
                    String typeText = typeTextField.getText();
                    String descriptionText = descriptionTextField.getText();
                    pokedeck.updateCard(index, new Card(nameText, lifePointsText, typeText, descriptionText));

                    window.revalidate();
                    window.repaint();

                    windowUpdateCard.setVisible(false);
                }
            });
            windowUpdateCard.setVisible(true);
        }
    }

    public static class RemoveCard implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            pokedeck.removeCard(index);
            System.out.println(pokedeck.deck.size());
            window.revalidate();
            window.repaint();
        }
    }

    public static class PreviousCard implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (index < pokedeck.deck.size()-1) {
                index++;
                nameCardLabel.setText(pokedeck.getCard(index).getName());
                lifePointsCardLabel.setText(pokedeck.getCard(index).getLifePoints());
                typeCardLabel.setText(pokedeck.getCard(index).getType());
                descriptionCardLabel.setText(pokedeck.getCard(index).getDescription());
            }
        }
    }

    public static class NextCard implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (index > 0) {
                index--;
                nameCardLabel.setText(pokedeck.getCard(index).getName());
                lifePointsCardLabel.setText(pokedeck.getCard(index).getLifePoints());
                typeCardLabel.setText(pokedeck.getCard(index).getType());
                descriptionCardLabel.setText(pokedeck.getCard(index).getDescription());
            }
        }
    }
}