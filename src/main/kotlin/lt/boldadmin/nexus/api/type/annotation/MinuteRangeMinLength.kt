package lt.boldadmin.nexus.api.type.annotation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
annotation class MinuteRangeMinLength(

    val message: String = "Duration can't be shorter than 15 minutes",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)
