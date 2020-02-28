package lt.boldadmin.nexus.api.type.annotation.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
annotation class BoundedMinuteIntervals(

    val message: String = "Day minute intervals are out of bounds",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)
