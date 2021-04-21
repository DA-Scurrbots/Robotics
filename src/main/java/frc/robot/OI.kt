package frc.team6502.robot

import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.team6502.robot.commands.ToggleDirection
import frc.team6502.robot.commands.ToggleBoost
import frc.team6502.robot.subsystems.Drivetrain
import java.util.function.BooleanSupplier
import kotlin.math.abs

object OI {
    val Joystick = edu.wpi.first.wpilibj.Joystick(Constants.JOSYSTICK_ID).apply {
        Trigger(BooleanSupplier { getRawButtonPressed(Constants.TRIGGER_PORT) }).whileActiveOnce(ToggleDirection())
    }
    val controllerThrottle: Double
        get() = value((Joystick.throttle*0.5)+0.5)
    val controllerX: Double
        get() = value(Joystick.x)
    val controllerZ: Double
        get() = value(Joystick.z)
    val controllerY: Double
        get() = value(-Joystick.y)
    fun value(v: Double): Double {
        var command = v

        command = when {
            command > Constants.DEADBAND -> (1 / (1 - Constants.DEADBAND)) * command - (Constants.DEADBAND / (1 - Constants.DEADBAND))
            command < -Constants.DEADBAND -> (1 / (1 - Constants.DEADBAND)) * command + (Constants.DEADBAND / (1 - Constants.DEADBAND))
            else -> 0.0
        }

        var retval = ((1 + 0.01 * Constants.EXPO * (command * command - 1.0)) * command)
        return (retval * (Constants.RATE + (abs(retval) * Constants.RATE * Constants.SUPER_RATE * 0.01)))
    }


}