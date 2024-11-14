package com.proyetofinalpoo.asistencias;

import java.io.File;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @author victortinoco
 */
public class DatabaseFileNotExistsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String dbFilePath = context.getEnvironment().getProperty("spring.datasource.url").replace("jdbc:sqlite:", "");
        File dbFile = new File(dbFilePath);
        return !dbFile.exists();
    }
}
