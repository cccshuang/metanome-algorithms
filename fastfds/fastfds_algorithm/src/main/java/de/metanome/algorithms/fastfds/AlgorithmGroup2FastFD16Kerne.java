package de.metanome.algorithms.fastfds;

import de.metanome.algorithm_integration.AlgorithmConfigurationException;
import de.metanome.algorithm_integration.AlgorithmExecutionException;
import de.metanome.algorithm_integration.input.RelationalInputGenerator;
import de.metanome.algorithms.depminer.depminer_helper.AlgorithmMetaGroup2;

public class AlgorithmGroup2FastFD16Kerne extends AlgorithmMetaGroup2 {

    @Override
    protected void buildSpecs() {

        // TODO Auto-generated method stub

    }

    @Override
    protected void executeAlgorithm() throws AlgorithmConfigurationException, AlgorithmExecutionException {

        Object opti = this.configurationRequirements.get(AlgorithmMetaGroup2.USE_OPTIMIZATIONS_TAG);
        int numberOfThreads = 16;
        if (opti != null && (Boolean) opti) {
            // TODO: evtl. müssen wir hier noch mehr machen
            numberOfThreads = Runtime.getRuntime().availableProcessors();
        }
        Object input = this.configurationRequirements.get(AlgorithmMetaGroup2.INPUT_TAG);
        if (input == null) {
            throw new AlgorithmConfigurationException("No input defined");
        }

        FastFD ffd = new FastFD(numberOfThreads, this.fdrr);
        ffd.execute(((RelationalInputGenerator) input).generateNewCopy());

    }
}
