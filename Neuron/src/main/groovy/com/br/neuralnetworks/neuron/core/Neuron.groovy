package com.br.neuralnetworks.neuron.core
/**
 * Created by efroes on 6/3/14.
 */
class Neuron {

    //Atributes
    def Random random
    def double sum
    def double[] weight
    def double[] inputs
    def double output
    def double sensibility

    //Clouseres
    def uSum =
            {
                sum = 0
                (0..inputs.size() - 1).each { i ->
                    sum += weight[i] * inputs[i]
                }
                return sum
            }

    def activeFunction =
            {
                output = Math.tanh(uSum())
               //this.output = 1 / (1 + Math.exp(-uSum()))
                return output
            }

    def derivative = {
        //return output * (1 - output)
        return 1/Math.pow(Math.cosh(output), 2)

    }

    def randomWeight = { int inputNumber ->
        random = new Random()
        weight = new double[inputNumber + 1]
        weight[0] = 1
        (1..inputNumber).each { i ->
            weight[i] = random.nextDouble() * 2
        }
    }
}
