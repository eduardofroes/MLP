package com.br.neuralnetworks.mlp.core

import com.br.neuralnetworks.neuron.core.Neuron

/**
 * Created by eduardo on 20/09/14.
 */
class MLPLayer {

    def String nameOfLayer
    def int neuralNumber
    def List<Neuron> lstOfNeurons


    public def setInput = { double []inputs ->

        lstOfNeurons.each {n ->

            n.inputs = new double[inputs.size() + 1]
            n.inputs[0] = 1
            def i = 1
            (inputs).each {value ->
                n.inputs[i] = value
                i++
            }

        }

        //lstOfNeurons*.inputs = inputs
    }

    public def initLayer = {int inputNumber, int neuralNumber ->

        lstOfNeurons = new ArrayList<Neuron>()


        (1.. neuralNumber).each { i ->
            def neuron = new Neuron()
            neuron.randomWeight(inputNumber)
            lstOfNeurons << neuron
        }
    }

    public def activeNeurons = {

        double []output = new double[lstOfNeurons.size()]
        int i = 0
        lstOfNeurons.each { n ->
            output[i] = n.activeFunction()
            i++
        }

        return output

    }

    public updateNeuronsWeight(double alfa){
        lstOfNeurons.each {neuron ->
            (0.. neuron.weight.size()-1).each {i->
                neuron.weight[i] -= alfa * neuron.sensibility * neuron.inputs[i]
            }
        }
    }

}
