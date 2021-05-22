import Dependency._

ThisBuild / scalafixDependencies += organizeImports
ThisBuild / scalacOptions ++= Seq(
  "-Ymacro-annotations",
  "-Ywarn-macros:after",
  "-P:semanticdb:synthetics:on",
  "-target:jvm-1.8",
)

lazy val commonSettings: Seq[SettingsDefinition] = Seq(
  organization := "com.github.scalagdx",
  scalaVersion := "2.13.6",
  crossScalaVersions := Seq("2.13.6", "2.12.13"),
  libraryDependencies ++= Seq(
    compilerPlugin(kindProjector cross CrossVersion.full),
    compilerPlugin(betterMonadicFor),
    catsCore,
    gdxCore,
    weaverCats % Test,
    weaverCatsCheck % Test,
  ),
  testFrameworks += new TestFramework("weaver.framework.CatsEffect"),
  wartremoverErrors ++= Warts.allBut(
    Wart.ImplicitParameter,
    Wart.ImplicitConversion,
    Wart.Any,
    Wart.Nothing,
    Wart.Serializable,
    Wart.JavaSerializable,
    Wart.Product,
    Wart.PlatformDefault,
    Wart.Overloading,
    Wart.StringPlusAny,
    Wart.Var,
    Wart.Equals,
    Wart.DefaultArguments,
  ),
  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
)

lazy val root = (project in file("."))
  .settings(
    Compile / unmanagedSourceDirectories := Nil,
    Test / unmanagedSourceDirectories := Nil,
  )
  .aggregate(
    core,
    backendLwjgl,
  )

lazy val core = (project in file("modules/core"))
  .settings(commonSettings: _*)
  .settings(
    name := "sdx-core",
    libraryDependencies ++= Seq(
      fs2,
      catsEffectKernel,
    ),
  )

lazy val backendLwjgl = (project in file("modules/backend-lwjgl"))
  .dependsOn(core)
  .settings(commonSettings: _*)
  .settings(
    name := "sdx-backend-lwjgl",
    libraryDependencies ++= Seq(
      fs2,
      catsKernel,
      catsEffectKernel,
      lwjgl2,
      gdxBackendLwjgl,
    ),
  )
