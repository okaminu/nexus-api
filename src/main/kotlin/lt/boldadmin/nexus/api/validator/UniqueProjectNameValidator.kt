package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.service.UserService
import lt.boldadmin.nexus.api.type.annotation.UniqueProjectName
import lt.boldadmin.nexus.api.type.entity.Project
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueProjectNameValidator: ConstraintValidator<UniqueProjectName, Project> {

    lateinit var userService: UserService

    override fun initialize(constraintAnnotation: UniqueProjectName) {}

    override fun isValid(project: Project, context: ConstraintValidatorContext) =
        userService.isProjectNameUnique(project.name, project.id, userService.getByProjectId(project.id).id)

}