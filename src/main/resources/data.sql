INSERT
INTO
  users
  (name, surname, avatar, mail, password)
VALUES
  ('Xavier', 'Patata', 'me.jpg', 'mail@mail.com', 'password');
INSERT
INTO
  users
  (name, surname, avatar, mail, password)
VALUES
  ('User', '2', 'user.jpg', 'mail@mail.com', 'password');
INSERT
INTO
  instants
  (title, `description`, image, location, creator_id)
VALUES
  ('Paris 2017', 'Lovely place!', 'paris.jpg', 'Paris, France', 1);
INSERT
INTO
  instants
  (title, `description`, image, location, creator_id)
VALUES
  ('London 2019', 'Fantastic city!', 'london.jpg', 'London, UK', 1);
INSERT
INTO
  instants
  (title, `description`, image, location, creator_id)
VALUES
  ('Al cel de Catalunya', 'Sempre amunt!', 'lapica.jpg', 'La Pica d Estats 3.143m, Catalunya', 2);
INSERT
INTO
  comments
  (comment, date, creator_id, instant_id)
VALUES
  ('M''encanta aquest lloc!', '07/07/22', 1, 1);