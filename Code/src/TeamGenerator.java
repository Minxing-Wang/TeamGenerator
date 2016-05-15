import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TeamGenerator extends JFrame {

    public final JPanel teamGenerator = new JPanel();
    public final CardLayout cardLayout = new CardLayout();
    public Team libsList = new Team("Libs");
    public Team midsList = new Team("Mids");
    public Team powerList = new Team("Powers");
    public Team offList = new Team("Off");
    public Team setterList = new Team("Setter");
    public Team randomsList = new Team("Randoms");
    public int playersPerTeam;
    JTextArea teamsText = new JTextArea(8,25);
    final TextField nameText = new TextField();
    final TextField positionText = new TextField();
    final Label entered = new Label("Enter a Player");

    public TeamGenerator(String name) {
        super(name);
        setResizable(true);
    }

    public void setUpGame(final Container pane) {

        ///////////////////////////First Pane, Select Number of players per team ////////////////////////////
        final JPanel playerPerTeamSelection = new JPanel();
        final GridLayout teamNumSeletionLayout= new GridLayout(5,1);
        playerPerTeamSelection.setLayout(teamNumSeletionLayout);

        JButton twoVStwo = new JButton("2 VS 2");
        JButton threeVSthree = new JButton("3 VS 3");
        JButton fourVSfour = new JButton("4 VS 4");
        JButton fiveVSfive = new JButton("5 VS 5");
        JButton sixVSsix = new JButton("6 VS 6");
        twoVStwo.setSize(new Dimension(40,20));
        threeVSthree.setSize(new Dimension(40,20));
        fourVSfour.setSize(new Dimension(40,20));
        fiveVSfive.setSize(new Dimension(40,20));
        sixVSsix.setSize(new Dimension(40, 20));
        playerPerTeamSelection.add(twoVStwo);
        playerPerTeamSelection.add(threeVSthree);
        playerPerTeamSelection.add(fourVSfour);
        playerPerTeamSelection.add(fiveVSfive);
        playerPerTeamSelection.add(sixVSsix);

        twoVStwo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playersPerTeam = 2;
                cardLayout.show(teamGenerator, "addPlayerPane");
                nameText.requestFocusInWindow();
            }
        });

        threeVSthree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playersPerTeam = 3;
                cardLayout.show(teamGenerator,"addPlayerPane");
                nameText.requestFocusInWindow();
            }
        });

        fourVSfour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playersPerTeam = 4;
                cardLayout.show(teamGenerator,"addPlayerPane");
                nameText.requestFocusInWindow();
            }
        });

        fiveVSfive.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playersPerTeam = 5;
                cardLayout.show(teamGenerator,"addPlayerPane");
                nameText.requestFocusInWindow();
            }
        });

        sixVSsix.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playersPerTeam = 6;
                cardLayout.show(teamGenerator,"addPlayerPane");
                nameText.requestFocusInWindow();
            }
        });

        ///////////////////////////Second Pane, Adding Players ////////////////////////////

        final JPanel addPlayerPane = new JPanel();
        final GroupLayout addPlayerLayout = new GroupLayout(addPlayerPane);
        addPlayerLayout.setAutoCreateGaps(true);
        addPlayerLayout.setAutoCreateContainerGaps(true);
        addPlayerPane.setLayout(addPlayerLayout);
        Label nameLabel = new Label("Name");
        Label positionLabel = new Label ("Position");
        final JButton addPlayer = new JButton("Add Player");
        JButton makeTeamsButton = new JButton("Make Teams");
        Label libs = new Label("Libs = L");
        Label mids = new Label("Mids = M");
        final Label power = new Label("Power = P");
        Label out = new Label("Offside = O");
        Label setter = new Label("Setter = S");
        final JButton addPlayerBackButton = new JButton("Back");

        addPlayerBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(teamGenerator, "playerPerTeamSelection");
            }
        });

        addPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addCurrentPlayer();
            }
        });

        makeTeamsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                makeTeams();
            }
        });
        

        addPlayerLayout.setHorizontalGroup(addPlayerLayout.createSequentialGroup()
                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLabel)
                                        .addComponent(positionLabel)
                        )
                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(entered)
                                        .addComponent(nameText)
                                        .addComponent(positionText)
                                        .addGroup(addPlayerLayout.createSequentialGroup()
                                                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(libs)
                                                                        .addComponent(out)
                                                        )
                                                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(mids)
                                                                        .addComponent(setter)
                                                        )
                                                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(power)
                                                        )
                                        )
                                        .addGroup(addPlayerLayout.createSequentialGroup()
                                                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(addPlayer)
                                                        )

                                                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(makeTeamsButton)
                                                        )
                                                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(addPlayerBackButton)
                                                        )
                                        )
                        )
        );

        addPlayerLayout.setVerticalGroup(addPlayerLayout.createSequentialGroup()
                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(entered)
                        )
                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameText)
                        )

                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(positionLabel)
                                        .addComponent(positionText)
                        )

                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(libs)
                                        .addComponent(mids)
                                        .addComponent(power)
                        )
                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(out)
                                        .addComponent(setter)
                        )

                        .addGroup(addPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addPlayer)
                                        .addComponent(makeTeamsButton)
                                        .addComponent(addPlayerBackButton)
                        )
        );


        nameText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   addCurrentPlayer();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        positionText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addCurrentPlayer();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        ///////////////////////////Third Pane, Showing Teams and Players ////////////////////////////
        final JPanel showTeamsPane = new JPanel();
        final GroupLayout teamGroupLayout = new GroupLayout(showTeamsPane);
        teamGroupLayout.setAutoCreateGaps(true);
        teamGroupLayout.setAutoCreateContainerGaps(true);
        showTeamsPane.setLayout(teamGroupLayout);
        final JScrollPane teamsPane = new JScrollPane(teamsText);
        teamsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JButton rerandButton = new JButton("Rerandomize");
        JButton teamsBackButton = new JButton("Back");
        teamsText.setFont(new Font("ARIAL", 0, 16));
        teamsText.setEditable(false);

        teamsBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(teamGenerator, "addPlayerPane");
            }
        });

        rerandButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                makeTeams();
            }
        });

        teamGroupLayout.setHorizontalGroup(teamGroupLayout.createSequentialGroup()
                        .addGroup(teamGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(teamsPane)

                        )
                        .addGroup(teamGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(rerandButton)
                                        .addComponent(teamsBackButton)
                        )
        );

        teamGroupLayout.setVerticalGroup(teamGroupLayout.createSequentialGroup()
                        .addGroup(teamGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(teamsPane)
                                        .addComponent(rerandButton)
                        )
                        .addGroup(teamGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(teamsBackButton)
                        )
        );


        ///////////////////////////Putting Everything Together ////////////////////////////
        pane.add(teamGenerator, BorderLayout.NORTH);
        teamGenerator.setLayout(cardLayout);
        teamGenerator.add(playerPerTeamSelection, "playerPerTeamSelection");
        teamGenerator.add(addPlayerPane, "addPlayerPane");
        teamGenerator.add(showTeamsPane, "showTeamsPane");
        cardLayout.show(teamGenerator, "playerPerTeamSelection");

    }

    public List<Team> makeTeams(List<Team> allPlayers, int numTeams){
        teamsText.setText("");
        List<Team> finishedTeams = new ArrayList<Team>();
        List<Team> workingteam = allPlayers;

        if(!(playersPerTeam==6)){
            List<Team> noPosTeams = new ArrayList<Team>();
            Team noPosTeam = new Team("");
            noPosTeams.add(noPosTeam);
            for(Team t: allPlayers){
                for(Player p : t.getPlayers()){
                    noPosTeam.addPlayer(p);
                }
            }
            workingteam = noPosTeams;
        }

        for(int i = 1 ; i <numTeams+1; i++){
            finishedTeams.add(new Team(Integer.toString(i)));
        }
        for(Team t: workingteam){
            int counter = 0;
            int maxRand = t.getSize();
            while(maxRand>0){
                Random random = new Random();
                int randomNum = random.nextInt(maxRand);
                finishedTeams.get(counter % numTeams).addPlayer(t.getPlayers().get(randomNum));
                counter ++;
                Player player = t.getPlayers().remove(randomNum);
                t.addPlayer(player);
                maxRand--;
            }

        }

        return finishedTeams;
    }

    public void makeTeams(){
        teamsText.setText("");
        int numOfTeams = (int) Math.floor((libsList.getSize() + midsList.getSize() +
                powerList.getSize() + offList.getSize() +
                setterList.getSize() + randomsList.getSize()) / playersPerTeam);
        if (numOfTeams == 0) {
            JOptionPane.showMessageDialog(null, "Please enter more players", "Number of Players Input Error", JOptionPane.ERROR_MESSAGE);
        } else {
            List<Team> allPlayers = new ArrayList<Team>();
            allPlayers.add(libsList);
            allPlayers.add(midsList);
            allPlayers.add(powerList);
            allPlayers.add(offList);
            allPlayers.add(setterList);
            allPlayers.add(randomsList);
            List<Team> readyTeams = makeTeams(allPlayers, numOfTeams);
            for (Team t : readyTeams) {
                teamsText.setText(teamsText.getText() + "                  Team" + t.getName() + "\n");
                for (Player p : t.getPlayers()) {
                    teamsText.setText(teamsText.getText() + "         " + p.getName() + "\n");
                }
            }
            cardLayout.show(teamGenerator, "showTeamsPane");

        }
    }

    public void addCurrentPlayer(){
        teamsText.setText("");
        String name = nameText.getText();
        String position = positionText.getText().toUpperCase();
        if (playersPerTeam == 6 && position.equals("")) {
            JOptionPane.showMessageDialog(null, "Please put L, M, P, O or S for position for 6 VS 6", "Position Missing Error", JOptionPane.ERROR_MESSAGE);
            positionText.requestFocusInWindow();
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input a player name", "Name Input Error", JOptionPane.ERROR_MESSAGE);
        } else if ((position.equals("L")) || (position.equals("M")) || (position.equals("P")) || (position.equals("O")) || (position.equals("S")) || (position.equals(""))) {
            Player player = new Player(name, position);

            if (position.equals("L")) {
                libsList.addPlayer(player);
            } else if (position.equals("M")) {
                midsList.addPlayer(player);
            } else if (position.equals("P")) {
                powerList.addPlayer(player);
            } else if (position.equals("O")) {
                offList.addPlayer(player);
            } else if (position.equals("S")) {
                setterList.addPlayer(player);
            } else if (position.equals("")) {
                randomsList.addPlayer(player);
            }
            nameText.setText("");
            positionText.setText("");
            entered.setText(name + " has been entered");

        } else {
            JOptionPane.showMessageDialog(null, "Please put L, M, P, O or S for position, you have entered: " + position, "Position Input Error", JOptionPane.ERROR_MESSAGE);
            positionText.setText("");
        }
        nameText.requestFocusInWindow();


    }


    private static void createAndShowGUI() {
        //Create and set up the window.
        TeamGenerator frame = new TeamGenerator("Team Generator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUpGame(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}