use adlister_db;

INSERT INTO ads(user_id, title, description) VALUES
  (1, 'Lovely Kitten', 'Found this lovely baby girl in a tree outside of my work. Unfortunately, I have cat allergies, so I''m unable to keep her, but she is very friendly and affectionate. I definitely think that she was someone''s kitty before getting lost. I''ve tried to find her owner, but this is already day two and I''m not fairing well. Luckily, I had a bowl to feed her in, but I don''t have anything else a cat might need. Please take this baby girl to a good home.'),
  (1, 'New in box 62'''' Cat tree - $50', 'If you pick up this tree at the Walmart Supercenter parking lot located at 4331 Thousand Oaks, San Antonio, TX 78217 on the NE side of San Antonio. New 62 inch cat tree. Unassembled in the sealed box. PLEASE READ - This cat tree is not made for jumbo 18 pound cats but is made for smaller cats and kittens. My cat who weighs in at 10 pounds and my foster kittens love their tree. Made with fleece covered material. Color is Leopard skin.'),
  (2, 'Assorted Video Games', 'NINTENDO DS, Need 4 speed - $8, DBZ - $15, Transformers auto - $5, Transformers decepticons - $5'),
  (2, 'Super Mario AllStars+Super Mario World 4 D SNES!', 'Have 4 sell a Snes original Cartridge of SUPER MARIO ALLSTARS N SUPER MARIO WORLD ALL IN 1 GAME CARTRIDGE!... 5 Games total!... ORIGINAL SNES GAME from 1994!... ASKING $95 Cash'),
  (3, 'Antique Cameras', 'Kodak-Brownie Starflex Camera with Kodak Rotary Flasholder uses 127 Film, Kodak Duaflex II, about 1950-1954, uses 620 Film, Kodak Brownie No.2 Model C. About 1911, uses 116 Film.'),
  (3, 'Canon EOS Rebel T4i DSLR with 18-55mm EF-S IS II Lens', 'Canon is proud to introduce its most sophisticated Rebel ever--the EOS Rebel T4i DSLR! Built to make advanced photography simple and fun, the new Rebel T4i delivers phenomenal image quality, high performance, and fast, intuitive operation. This EOS Rebel amps up the speed with the powerful DIGIC 5 Image Processor that helps make high-speed continuous shooting of up to 5.0 fps possible--great for capturing fast action.');

insert into categories(category)
    VALUES ('RPG'),
      ('Puzzle'),
      ('Fighting'),
      ('Shooter'),
      ('Simulation'),
      ('Strategy'),
      ('Racing'),
      ('Sports'),
      ('Party Game'),
      ('Trivia');

update ads
set category = 'Simulation' where id = 1;

