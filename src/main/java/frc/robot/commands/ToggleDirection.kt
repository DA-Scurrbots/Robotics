package frc.team6502.robot.commands

import edu.wpi.first.wpilibj2.command.InstantCommand
import frc.team6502.robot.subsystems.Drivetrain

class ToggleDirection: InstantCommand() {

    override fun execute() {
        Drivetrain.switchFrontIsFront()
    }


}
class ToggleBoost: InstantCommand() {

    override fun execute() {
        Drivetrain.ToggleBoost()
    }


}