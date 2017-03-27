package com.rezidor.repo.bootstrap;

import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.repo.transaction.RetryingTransactionHelper;
import org.alfresco.service.transaction.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Thomas.Straetmans on 22/03/2017.
 */
abstract public class InitializingRepo implements InitializingBean {
    private final static Logger logger = LoggerFactory.getLogger(InitializingRepo.class);

    @Autowired
    private TransactionService transactionService;

    public void afterPropertiesSet() {
        transactionService.getRetryingTransactionHelper().doInTransaction(new RetryingTransactionHelper.RetryingTransactionCallback<Object>() {

            public Object execute() throws Throwable {
                AuthenticationUtil.runAs(new AuthenticationUtil.RunAsWork<Object>() {

                    public Object doWork() throws Exception {
                        init();
                        return null;
                    }
                }, AuthenticationUtil.getAdminUserName());
                return null;
            }
        });
    }

    abstract public void init() throws IOException;

}
