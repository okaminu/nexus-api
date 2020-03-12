package lt.boldadmin.nexus.api.type.annotation.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
annotation class UniqueProjectName(

    val message: String = "Duplicate project name",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)
