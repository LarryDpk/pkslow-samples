package com.pkslow.springboot.common.springbootcondition;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.List;

public class PkslowCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        BindResult<List<String>> maxBindResult = Binder.get(context.getEnvironment()).bind("pkslow.condition.max", Bindable.listOf(String.class));
        BindResult<List<String>> minBindResult = Binder.get(context.getEnvironment()).bind("pkslow.condition.min", Bindable.listOf(String.class));

        if ( (maxBindResult.isBound() && !maxBindResult.get().isEmpty()) && (minBindResult.isBound() && !minBindResult.get().isEmpty()) ) {
            List<String> maxs = maxBindResult.get();
            List<String> mins = minBindResult.get();
            int max = Integer.parseInt(maxs.get(0));
            int min = Integer.parseInt(mins.get(0));

            if (max < 1000 && min > 0) {
                return ConditionOutcome.match();
            }

        }

        return ConditionOutcome.noMatch("pkslow.condition.max/pkslow.condition.min not matches");
    }
}
