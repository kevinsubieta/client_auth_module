package uagrm.soe.awesomelogin.listeners

import java.util.*
import kotlin.reflect.KClass

interface ControllerListener {
    fun notifyController(anyObject : Any?, fromClass : Any)
}