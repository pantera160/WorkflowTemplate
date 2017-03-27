package com.rezidor.repo.workflows;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created by Thomas.Straetmans on 22/03/2017.
 */
@Component("task.workflow")
public class DemoWorkflow implements ExecutionListener{


    public void notify(DelegateExecution execution) throws Exception {

    }
}
