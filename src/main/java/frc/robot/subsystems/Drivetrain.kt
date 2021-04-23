package frc.team6502.robot.subsystems
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team6502.robot.Constants
import frc.team6502.robot.commands.DefaultDrive
//import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.drive.Vector2d


object Drivetrain: SubsystemBase() {
    val leftFront = Spark(Constants.LEFT_FRONT_ID)
    val leftBack  = Spark(Constants.LEFT_BACK_ID)
    val leftSide = SpeedControllerGroup(leftFront, leftBack)
    val rightFront  = Spark(Constants.RIGHT_FRONT_ID)
    val rightBack  = Spark(Constants.RIGHT_BACK_ID)
    val rightSide = SpeedControllerGroup(rightFront, rightBack)
//    val robotDrive = DifferentialDrive(leftFront, leftBack, rightFront, rightBack)
    val robotDrive = DifferentialDrive(leftSide,rightSide)

    init {
        this.defaultCommand = DefaultDrive()
    }

    var Boost = false // true turns the robot into boost mode. this ignores the speed dial on the
    var frontIsFront = 1

    fun switchFrontIsFront(){
        frontIsFront*=-1
    }
    fun ToggleBoost(){
        Boost = !Boost
    }

    fun drive ( speed: Vector2d, rotation:Double){
//        robotDrive.isSafetyEnabled()
        println("x: " + speed.x.toString() + " y: " + speed.y.toString())
        robotDrive.arcadeDrive(speed.y, rotation)//driveCartesian(speed.x, speed.y, rotation)
    }

}
