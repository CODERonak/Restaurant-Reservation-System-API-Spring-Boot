{ pkgs, ... }: {

  channel = "stable-25.05";
  packages = [
    pkgs.zulu
    pkgs.maven
    pkgs.mysql84
  ];

  services.mysql = {
    enable = true;
    package = pkgs.mariadb;
  };

  env = { };
  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "vscjava.vscode-java-pack"
    ];
    workspace = {
      # Runs when a workspace is first created with this `dev.nix` file
      onCreate = {
        install = "mvn clean install";
      };
      # Runs when a workspace is (re)started
      onStart = {
        run-server = "PORT=3000 mvn spring-boot:run";
      };
    };
  };
}