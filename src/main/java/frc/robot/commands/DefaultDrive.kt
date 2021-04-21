package frc.team6502.robot.commands

import edu.wpi.first.wpilibj.drive.Vector2d
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.team6502.robot.Constants
import frc.team6502.robot.OI
import frc.team6502.robot.subsystems.Drivetrain
import frc.team6502.robot.subsystems.Drivetrain.ToggleBoost

class DefaultDrive: CommandBase() {


    init {
        addRequirements(Drivetrain)
    }
    override fun initialize() {

    }

    override fun execute() {
/*
        SmartDashboard.putNumber("Y AXIS:" , OI.controllerY)
        SmartDashboard.putNumber("X AXIS:" , OI.controllerX)

        try {
            Shuffleboard.getTab("Test").addNumber("Y") { OI.controllerY }
            Shuffleboard.getTab("Test").addNumber("X") { OI.controllerX }
        } catch (e: Exception) {
            e.printStackTrace()
        }*/
        var control = Vector2d(
            OI.controllerY * Drivetrain.frontIsFront,// * Constants.MAX_SPEED * OI.controllerThrottle,
            OI.controllerX * Drivetrain.frontIsFront// * Constants.MAX_SPEED * OI.controllerThrottle
        )
/*        if (true) {*/
        Drivetrain.drive(control, 0.0)/*
        }*//* else {
//            Drivetrain.drive(OI.controllerY * Drivetrain.frontIsFront * Constants.MAX_SPEED, OI.controllerX * Constants.MAX_SPEED * Drivetrain.frontIsFront)
        }*/
    }

    override fun isFinished() = false
}