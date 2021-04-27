package frc.team6502.robot

//    ---- Controls ----
var GeneralControls = true
var Forward = true      // Robot can move forward 
var Backward = true     // Robot can move backward
var Strafe = true       // Robot can strafe (side to side)
var Turning = true      // Robot can turn


//    ---- Controller Inputs ----
val LeftJoy = true
val RightJoy = true

//    ---- Sensors ----
val BuiltinAccelerometer = false

//    ---- Limiters ----
/// Speed Limits
val GeneralSpeed: Float = 1 // not Implemented


//    ---- Debugging ---- 
///Generally keep these off
val ControllerPositions = false



fun Setup() {
    if !GeneralControls {
        Forward = GeneralControls
        Backward = GeneralControls
        Strafe = GeneralControls
        Turning = GeneralControls
    }
}