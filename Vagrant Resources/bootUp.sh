sudo apt-get update
sudo apt-get install -y g++
sudo apt-get install -y curl
curl -sL https://deb.nodesource.com/setup_4.x | sudo sh
sudo apt-get install -y nodejs
sudo npm i -g npm@latest
node -v && npm -v
sudo npm install npme -g --unsafe

#curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -
# sudo apt-get install -y nodejs
# npm install -g @angular/cli

debconf-set-selections <<< 'mysql-server mysql-server/root_password password abcd1234'
debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password abcd1234'
apt-get update
apt-get install -y mysql-server

apt-get install -y git
