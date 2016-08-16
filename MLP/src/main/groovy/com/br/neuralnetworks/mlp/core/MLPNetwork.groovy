package com.br.neuralnetworks.mlp.core

/**
 * Created by efroes on 6/2/14.
 */
class MLPNetwork {

    /**
     *
     * Variables and Objects
     */
    double eqm = 10
    double error = 0
    double minError = 0.0000001
    def double alfa = 0
    def double [][]inputs
    def double []wanted
    def maxIteration = 1000
    def List<MLPLayer> lstOfLayer
    double sigma = 0;

    /**
     * Closures
     */
    def initializeNetwork(int numOfLayers, int numOfNeuronPerLayers, double [][]inputs, double []wanted, double alfa){

        this.alfa = alfa
        this.inputs = inputs
        this.wanted = wanted

        lstOfLayer = new ArrayList<MLPLayer>()

        (1.. numOfLayers).each { i ->
            def layer = new MLPLayer()
            layer.initLayer(i ==1? inputs[0].size():numOfNeuronPerLayers, numOfNeuronPerLayers)
            lstOfLayer << layer
        }

        def out = new MLPLayer()
        out.initLayer(numOfNeuronPerLayers, 1)

        lstOfLayer << out
    }

    def processMLPNetwork (int inputIndex) {

        int i = 0
        double []output

        lstOfLayer.each() { layer ->
            if(i == 0) {
                layer.setInput(inputs[inputIndex])
            }
            else
            {
                layer.setInput(output)
            }

            output = layer.activeNeurons()
            i++
        }
    }

    def evaluate(double []value) {
        int i = 0
        double[] output

        lstOfLayer.each() { layer ->
            if (i == 0) {
                layer.setInput(value)
            } else {
                layer.setInput(output)
            }
            output = layer.activeNeurons()
            i++
        }
    }


    def trainningNetwork(){
        def iteration = 0
        eqm = 10
        while (iteration < maxIteration && eqm > minError) {
            println("--------Iterator:${iteration}-----------")
            eqm = 10
            error = 0
            for(int i= 0; i < wanted.length; i++)
            {
                //sleep(800)
                //println("##########PROPAGANDO###########")
                println("PADRÃO:${inputs[i]}")
                println("DESEJADA:${wanted[i]}")
                evaluate(inputs[i])
                //processMLPNetwork(i)
                println("SAIDA:${getOutPut()}")
                //println("##########RETROALIMENTANDO###########")
                backPropagation(i)
            }
            sigma = 0
            eqm = error / wanted.size();
            println("EQM:" + eqm)
            //sleep(2000)

            iteration++
        }
    }

    def backPropagation(int indexPattern){

        for(int i=lstOfLayer.size() - 1; i>=0; i--)
        {
            //println("##########Layer:${i}###########")
            def erro = 0
            if(i == (lstOfLayer.size() -1)){
                erro =  wanted[indexPattern] - getOutPut()
                error += erro * erro

                lstOfLayer[i].lstOfNeurons.each { neuron ->
                    neuron.sensibility =  -2 * neuron.derivative() * erro
                }
            }
            else
            {

                lstOfLayer[i + 1].lstOfNeurons.each { neuron1 ->
                    neuron1.weight.each {w ->
                        sigma += neuron1.sensibility * w
                    }
                }
                lstOfLayer[i].lstOfNeurons.each { neuron ->
                    neuron.sensibility = neuron.derivative() * sigma;
                }
            }

        }
        sigma = 0
        lstOfLayer*.updateNeuronsWeight(alfa)
    }

    public double getOutPut()
    {
        return lstOfLayer.get(lstOfLayer.size() - 1).lstOfNeurons[0].getOutput()
    }


}
