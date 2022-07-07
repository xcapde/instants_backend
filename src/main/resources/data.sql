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
  ('London', 'Amazing place!', 'lnd.jpg', 'London, UK', 1);
  INSERT
  INTO
    instants
    (title, `description`, image, location, creator_id)
  VALUES
    ('Al sostre de Catalunya, 3143m', 'Bonic passeig abans d''esmorzar!', 'pica.jpg', 'La Pica d''Estats, Catalunya', 1);


INSERT
INTO
  comments
  (comment, creator_id, instant_id)
VALUES
  ('Aw! I love London! ', 1, 1);

INSERT
INTO
  comments
  (comment, creator_id, instant_id)
VALUES
  ('Perfect place! ', 1, 1);
