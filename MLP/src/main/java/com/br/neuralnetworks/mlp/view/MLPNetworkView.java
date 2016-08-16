package com.br.neuralnetworks.mlp.view;

import com.br.neuralnetworks.mlp.core.MLPNetwork;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MLPNetworkView extends JDialog {

    private JPanel contentPane;
    private JLabel numLayersLabel;
    private JLabel numNeuronsLabel;
    private JButton trainnigNetworkButton;
    private JButton testButton;
    private JTextField txtNeurons;
    private JTextField txtLayers;
    private JTextField txtWanted;
    private JTextField txtInput;
    private JLabel inputLabel;
    private JButton initializeNetworkButton;
    private JLabel wantedLabel;
    public MLPNetwork NeuralNetwork;
    public double [][]test;
    public double []testwanted;

    public MLPNetworkView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(initializeNetworkButton);

        NeuralNetwork = new MLPNetwork();

        initializeNetworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] obj = txtInput.getText().split(",");


                double [][]lstInput = new double[][]
                {
                        {5.1,3.5,1.4,0.2},
                        {4.9,3.0,1.4,0.2},
                        {4.7,3.2,1.3,0.2},
                        {4.6,3.1,1.5,0.2},
                        {5.0,3.6,1.4,0.2},
                        {5.4,3.9,1.7,0.4},
                        {4.6,3.4,1.4,0.3},
                        {5.0,3.4,1.5,0.2},
                        {4.4,2.9,1.4,0.2},
                        {4.9,3.1,1.5,0.1},
                        {5.4,3.7,1.5,0.2},
                        {4.8,3.4,1.6,0.2},
                        {4.8,3.0,1.4,0.1},
                        {4.3,3.0,1.1,0.1},
                        {5.8,4.0,1.2,0.2},
                        {5.7,4.4,1.5,0.4},
                        {5.4,3.9,1.3,0.4},
                        {5.1,3.5,1.4,0.3},
                        {5.7,3.8,1.7,0.3},
                        {5.1,3.8,1.5,0.3},
                        {5.4,3.4,1.7,0.2},
                        {5.1,3.7,1.5,0.4},
                        {4.6,3.6,1.0,0.2},
                        {5.1,3.3,1.7,0.5},
                        {4.8,3.4,1.9,0.2},
                        {5.0,3.0,1.6,0.2},
                        {5.0,3.4,1.6,0.4},
                        {5.2,3.5,1.5,0.2},
                        {5.2,3.4,1.4,0.2},
                        {4.7,3.2,1.6,0.2},
                        {4.8,3.1,1.6,0.2},
                        {5.4,3.4,1.5,0.4},
                        {5.2,4.1,1.5,0.1},
                        {5.5,4.2,1.4,0.2},
                        {4.9,3.1,1.5,0.1},
                        {5.0,3.2,1.2,0.2},
                        {5.5,3.5,1.3,0.2},
                        {4.9,3.1,1.5,0.1},
                        {4.4,3.0,1.3,0.2},
                        {5.1,3.4,1.5,0.2},
                        {5.0,3.5,1.3,0.3},
                        {4.5,2.3,1.3,0.3},
                        {4.4,3.2,1.3,0.2},
                        {5.0,3.5,1.6,0.6},
                        {5.1,3.8,1.9,0.4},

        
        ///-------------------------

                        {5.7,2.8,4.5,1.3},
                        {6.3,3.3,4.7,1.6},
                        {4.9,2.4,3.3,1.0},
                        {6.6,2.9,4.6,1.3},
                        {5.2,2.7,3.9,1.4},
                        {5.0,2.0,3.5,1.0},
                        {5.9,3.0,4.2,1.5},
                        {6.0,2.2,4.0,1.0},
                        {6.1,2.9,4.7,1.4},
                        {5.6,2.9,3.6,1.3},
                        {6.7,3.1,4.4,1.4},
                        {5.6,3.0,4.5,1.5},
                        {5.8,2.7,4.1,1.0},
                        {6.2,2.2,4.5,1.5},
                        {5.6,2.5,3.9,1.1},
                        {5.9,3.2,4.8,1.8},
                        {6.1,2.8,4.0,1.3},
                        {6.3,2.5,4.9,1.5},
                        {6.1,2.8,4.7,1.2},
                        {6.4,2.9,4.3,1.3},
                        {6.6,3.0,4.4,1.4},
                        {6.8,2.8,4.8,1.4},
                        {6.7,3.0,5.0,1.7},
                        {6.0,2.9,4.5,1.5},
                        {5.7,2.6,3.5,1.0},
                        {5.5,2.4,3.8,1.1},
                        {5.5,2.4,3.7,1.0},
                        {5.8,2.7,3.9,1.2},
                        {6.0,2.7,5.1,1.6},
                        {5.4,3.0,4.5,1.5},
                        {6.0,3.4,4.5,1.6},
                        {6.7,3.1,4.7,1.5},
                        {6.3,2.3,4.4,1.3},
                        {5.6,3.0,4.1,1.3},
                        {5.5,2.5,4.0,1.3},
                        {5.5,2.6,4.4,1.2},
                        {6.1,3.0,4.6,1.4},
                        {5.8,2.6,4.0,1.2},
                        {5.0,2.3,3.3,1.0},
                        {5.6,2.7,4.2,1.3},
                        {5.7,3.0,4.2,1.2},
                        {5.7,2.9,4.2,1.3},
                        {6.2,2.9,4.3,1.3},
                        {5.1,2.5,3.0,1.1},
                        {5.7,2.8,4.1,1.3}
                };

                /*for(int i=0; i < obj.length; i++)
                {
                    lstInput[i] = new double[]{Double.parseDouble(obj[i])};
                }

                String[] obj2 = txtWanted.getText().split(",");*/

                test = new double[][]{
                        {4.8,3.0,1.4,0.3},
                        {5.1,3.8,1.6,0.2},
                        {4.6,3.2,1.4,0.2},
                        {5.3,3.7,1.5,0.2},
                        {5.0,3.3,1.4,0.2},
                        {7.0,3.2,4.7,1.4},
                        {6.4,3.2,4.5,1.5},
                        {6.9,3.1,4.9,1.5},
                        {5.5,2.3,4.0,1.3},
                        {6.5,2.8,4.6,1.5}};

                testwanted = new double[]{1,1,1,1,1,-1,-1,-1,-1,-1};


                double []wanted = new double[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                                              -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                                              -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
                                               //0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

                /*for(int i=0; i < obj2.length; i++) {
                    wanted[i] = Double.parseDouble(obj2[i]);
                }*/

                NeuralNetwork.initializeNetwork(Integer.parseInt(txtLayers.getText()),
                                                Integer.parseInt(txtNeurons.getText()),
                                                lstInput,
                                                wanted,
                                                2);
            }

        });
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*String[] obj = txtInput.getText().split(",");

                double lstInput[] = new double[obj.length];

                for(int i=0; i < obj.length; i++)
                {
                    lstInput[i] = Double.parseDouble(obj[i]);
                }
                //double []s = new double[]{30,17,10};

                NeuralNetwork.evaluate(lstInput);
                System.out.println("Saida:"+NeuralNetwork.getOutPut());*/

                for (int i=0;i<test.length;i++){
                    NeuralNetwork.evaluate(test[i]);

                    String sTest = "[";

                        for(int k=0; k<test[i].length; k++)
                        {

                            if(k==test[i].length-1){
                                sTest+= test[i][k];
                            }
                            else
                            {
                                sTest+= test[i][k]+",";
                            }
                        }
                    sTest += "]";

                    System.out.println("Entrada:"+sTest);
                    System.out.println("Desejada:"+testwanted[i]);
                    System.out.println("Saida:"+NeuralNetwork.getOutPut());
                }
            }

        });
        trainnigNetworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NeuralNetwork.trainningNetwork();
            }

        });
    }

    public static void main(String[] args) {
        MLPNetworkView dialog = new MLPNetworkView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {

        numNeuronsLabel = new JLabel();
        trainnigNetworkButton = new JButton();
        testButton = new JButton();
        txtNeurons = new JTextField();
        txtLayers = new JTextField();
        txtWanted = new JTextField();
        txtInput = new JTextField();
        inputLabel = new JLabel();
        initializeNetworkButton = new JButton();

    }


}
