package frc.team6502.robot

import edu.wpi.first.wpilibj.command.button.Trigger
import frc.team6502.robot.commands.ToggleDirection
import frc.team6502.robot.commands.ToggleBoost
import frc.team6502.robot.subsystems.Drivetrain
import frc.team6502.robot.APrefrences
import frc.team6502.robot.Helpers.Vector3d
import java.util.function.BooleanSupplier
import kotlin.math.abs
import edu.wpi.first.wpilibj.BuiltinAccelerometer

object OI {
    private val BlAccelerometer = BuiltinAccelerometer()
    val Accelerometer: Vector3d?
        get() {
            if APrefrences.Accelerometer {
                return Vector3d(
                    BlAccelerometer.getX(),
                    BlAccelerometer.getY(),
                    BlAccelerometer.getZ()
                )
            } else {
                return null
            }
        }

    val LJoystick = edu.wpi.first.wpilibj.Joystick(Constants.LJOSYSTICK_ID).apply {
        // Trigger(BooleanSupplier { getRawButtonPressed(Constants.TRIGGER_PORT) }).whileActiveOnce(ToggleDirection())
    }
    val RJoystick = edu.wpi.first.wpilibj.Joystick(Constants.RJOSYSTICK_ID).apply {
        // Trigger(BooleanSupplier { getRawButtonPressed(Constants.TRIGGER_PORT) }).whileActiveOnce(ToggleDirection())
    }
    val controllerThrottle: Double
        get() = value((LJoystick.throttle*0.5)+0.5)
    val controllerRX: Double
        get() {
            if APrefrences.RightJoy {return value(RJoystick.x)} else {return 0}
        }
    val controllerRY: Double
        get() {
            if APrefrences.RightJoy {return value(-RJoystick.y)} else {return 0}
        }
    val joe: Vector2d
    val controllerRX: Double
        get() {
            if APrefrences.LeftJoy {return value(LJoystick.x)} else {return 0}
        }
    val controllerRY: Double
        get() {
            if APrefrences.LeftJoy {return value(-LJoystick.y)} else {return 0}
        }

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